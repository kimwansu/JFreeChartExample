package kr.ac.ulsan.klplab.dao;

public class SampleDataDao
{
    public SampleData[] getSampleDataset()
    {
        // 테스트용 데이터를 만들어서 리턴
        // 실제 구현에서는 데이터베이스 등에서 값을 가져오도록 할 것
        String[] dataLines = {
                "2010.02.\t2\t0\t13\t0\t1\t3\t5\t0\t0",
                "2010.05.\t1\t0\t8\t0\t1\t7\t0\t0\t0",
                "2010.06.\t0\t0\t0\t0\t0\t1\t0\t0\t0",
                "2010.07.\t41\t0\t70\t1\t19\t33\t42\t0\t17",
                "2010.08.\t1\t0\t5\t0\t2\t8\t2\t0\t1",
                "2010.09.\t7\t0\t5\t0\t2\t6\t0\t0\t4",
                "2010.10.\t1\t0\t2\t0\t0\t4\t0\t0\t0",
                "2010.11.\t11\t0\t7\t0\t1\t5\t0\t0\t1",
                "2010.12.\t5\t0\t8\t0\t1\t10\t2\t0\t2",
                "2011.03.\t0\t0\t0\t0\t0\t1\t0\t0\t0",
                "2011.04.\t3\t0\t5\t0\t5\t10\t7\t0\t2",
                "2011.05.\t7\t0\t9\t0\t3\t9\t6\t0\t2",
                "2011.07.\t1\t0\t1\t0\t0\t1\t1\t0\t2",
                "2011.10.\t0\t0\t1\t0\t0\t3\t0\t0\t0",
                "2011.11.\t13\t0\t22\t0\t1\t9\t3\t0\t9",
                "2011.12.\t0\t0\t4\t0\t0\t2\t3\t0\t2",
                "2012.02.\t0\t0\t0\t0\t0\t1\t0\t0\t0",
                "2012.05.\t0\t0\t3\t0\t0\t0\t0\t0\t0",
                "2012.06.\t1\t0\t1\t0\t1\t0\t0\t0\t0",
                "2012.07.\t0\t0\t0\t0\t0\t2\t1\t0\t3",
                "2012.09.\t3\t0\t3\t0\t0\t7\t0\t0\t3",
                "2012.12.\t5\t0\t39\t0\t11\t19\t29\t0\t3",
                "2013.01.\t0\t0\t2\t0\t0\t3\t0\t0\t0",
                "2013.04.\t0\t0\t3\t0\t4\t6\t3\t0\t1",
                "2013.08.\t3\t0\t3\t0\t0\t4\t1\t0\t1",
                "2013.09.\t1\t0\t2\t0\t0\t0\t1\t0\t2",
                "2013.10.\t2\t0\t5\t0\t0\t12\t4\t0\t0",
                "2013.11.\t1\t0\t27\t0\t3\t2\t1\t0\t3",
                "2014.03.\t1\t0\t2\t0\t1\t2\t0\t0\t0",
        };
        
        SampleData[] datas = new SampleData[dataLines.length];
        for (int i = 0; i < dataLines.length; i++)
            datas[i] = SampleData.MakeTestDataFromTabSeparatedText(dataLines[i]);
        
        return datas;
    }
    
    public static void main(String[] args)
    {
        // this is test
        
        SampleDataDao dao = new SampleDataDao();
        SampleData[] datas = dao.getSampleDataset();
        
        for (SampleData data : datas)
            System.out.println(data.toString());
    }
}
