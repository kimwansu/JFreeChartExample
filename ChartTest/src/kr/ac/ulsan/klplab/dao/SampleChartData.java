package kr.ac.ulsan.klplab.dao;

public class SampleChartData
{
    public String title;
    public int legendCount;
    public String categoryAxisLabel;
    public String valueAxisLabel;
    
    public SampleData[] dataset;
    public int width;
    public int height;
    
    public static SampleChartData getSampleChartData()
    {
        SampleChartData chartData = new SampleChartData();
        chartData.title = "차트 제목";
        chartData.legendCount = 9;
        chartData.categoryAxisLabel = "날짜";
        chartData.valueAxisLabel = "수치";
        
        SampleDataDao dao = new SampleDataDao();
        chartData.dataset = dao.getSampleDataset();
        chartData.width = 4096;
        chartData.height = 512;
        
        return chartData;
    }
}
