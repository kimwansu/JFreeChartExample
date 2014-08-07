package kr.ac.ulsan.klplab.chart;

import java.awt.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import kr.ac.ulsan.klplab.dao.*;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.title.*;
import org.jfree.data.category.*;

/**
 * Servlet implementation class SampleChartServlet
 */
@WebServlet("/SampleChartServlet")
public class SampleChartServlet extends HttpServlet
{
    // JFreeChart 라이브러리는 http://www.jfree.org/jfreechart/download.html에서 다운로드하여
    // jcommon-버전.jar와 jfreechart-버전.jar를 WEB-INF/lib 폴더에 넣어서 사용
    
    // JFreeChart의 사용법은 예제 소스(http://www.jfree.org/jfreechart/samples.html에서 다운로드)와 
    // API 문서(http://www.jfree.org/jfreechart/api/javadoc/index.html)를 참고
    
    private static final long serialVersionUID = 1L;
    private static final String hangulFontName = "맑은 고딕";
    
    // 차트에 들어가는 범례 항목의 수
    private int legendCount;
    
    // 차트 객체
    private JFreeChart chart;
    private CategoryPlot plot;
    
    // 차트 속성
    private String title;
    private String categoryAxisLabel;
    private String valueAxisLabel;
    private DefaultCategoryDataset dataset;
    private int width;
    private int height;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleChartServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        
        // 차트 속성 설정
        // 실제 구현에서는 컨트롤러에서 미리 자료를 준비해놓고
        // request 속성에 필요한 자료를 넣어서 사용할 것
        //SampleChartData chartAttribute = (SampleChartData)request.getAttribute("testChartAttribute");
        SampleChartData chartAttribute = SampleChartData.getSampleChartData();
        setupChart(chartAttribute);
        
        // 차트 만들기
        createChart();
        
        // 만든 차트를 이미지로 만들어서 출력하기
        response.setContentType("image/png");
        ServletOutputStream outputStream = response.getOutputStream();
        ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);
    }
    
    private void setupChart(SampleChartData chartData)
    {
        // 차트 내용 설정
        this.title = chartData.title;
        this.legendCount = chartData.legendCount;
        this.categoryAxisLabel = chartData.categoryAxisLabel;
        this.valueAxisLabel = chartData.valueAxisLabel;
        
        this.dataset = prepareChartData(chartData.dataset);
        this.width = chartData.chartWidth;
        this.height = chartData.chartHeight;
    }

    private DefaultCategoryDataset prepareChartData(SampleData[] datas)
    {
        // 차트 데이터 추가
        DefaultCategoryDataset chartData = new DefaultCategoryDataset();
        for (SampleData data : datas) {
            // chartData.addValue(값--y축, 범례, 분류--x축);
            chartData.addValue(data.getSize(), "size", data.getDate());
            chartData.addValue(data.getWeight(), "weight", data.getDate());
            chartData.addValue(data.getDesign(), "design", data.getDate());
            chartData.addValue(data.getBattery(), "battery", data.getDate());
            chartData.addValue(data.getSoundQuality(), "sound_quality", data.getDate());
            chartData.addValue(data.getPrice(), "price", data.getDate());
            chartData.addValue(data.getDisplay(), "display", data.getDate());
            chartData.addValue(data.getVelocity(), "velocity", data.getDate());
            chartData.addValue(data.getThickness(), "size", data.getDate());
        }
        
        return chartData;
    }
    
    private void createChart()
    {
        prepareBarChart();
        changeChartTitleTextFormat();
        changeChartCategoryAxisTextFormat();
        changeChartValueAxisTextFormat();
        changeChartItemValueFormat();
        changeChartLegendTextFormat();
        setChartAntiAlias(true);
    }
    
    private void prepareBarChart()
    {
        this.chart = ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel,
                dataset, PlotOrientation.VERTICAL, true, false, false);
        this.plot = (CategoryPlot)chart.getPlot();
    }
    
    private void changeChartTitleTextFormat()
    {
        TextTitle title = chart.getTitle();
        Font newFont = replaceFont(title.getFont());
        title.setFont(newFont);
        // title.setXXX 메서드로 차트 제목의 글자 서식을 바꿀 수 있음(아래 메서드도 같은 방법 적용 가능)
    }
    
    private Font replaceFont(Font font)
    {
        return new Font(hangulFontName, font.getStyle(), font.getSize());
    }
    
    private void changeChartCategoryAxisTextFormat()
    {
        CategoryAxis categoryAxis = plot.getDomainAxis();
        Font labelFont = replaceFont(categoryAxis.getLabelFont());
        categoryAxis.setLabelFont(labelFont);
        
        Font tickLabelFont = replaceFont(categoryAxis.getTickLabelFont());
        categoryAxis.setTickLabelFont(tickLabelFont);
    }
    
    private void changeChartValueAxisTextFormat()
    {
        ValueAxis valueAxis = plot.getRangeAxis();
        Font labelFont = replaceFont(valueAxis.getLabelFont());
        valueAxis.setLabelFont(labelFont);
        
        Font tickLabelFont = replaceFont(valueAxis.getTickLabelFont());
        valueAxis.setTickLabelFont(tickLabelFont);
    }
    
    private void changeChartItemValueFormat()
    {
        CategoryItemRenderer renderer = (CategoryItemRenderer)plot.getRenderer();
        StandardCategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        for (int i = 0; i < legendCount; i++) {
            renderer.setSeriesItemLabelGenerator(i, generator);
            renderer.setSeriesItemLabelsVisible(i, true);
            renderer.setSeriesItemLabelFont(i, new Font(hangulFontName, Font.BOLD, 12));
        }
    }
    
    private void changeChartLegendTextFormat()
    {
        LegendTitle legend = chart.getLegend();
        Font legendFont = legend.getItemFont();
        legend.setItemFont(replaceFont(legendFont));
    }
    
    private void setChartAntiAlias(boolean useAntiAlias)
    {
        chart.setAntiAlias(useAntiAlias);
        chart.setTextAntiAlias(useAntiAlias);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}
