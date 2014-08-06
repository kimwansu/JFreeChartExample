package kr.ac.ulsan.klplab.dao;

import java.util.Date;

public class SampleData
{
    private String date;
    private int size;
    private int weight;
    private int design;
    private int battery;
    private int soundQuality;
    private int price;
    private int display;
    private int velocity;
    private int thickness;
    
    public static SampleData MakeTestDataFromTabSeparatedText(String text)
    {
        // 매개변수가 많은 생성자를 만들어서 사용하는 대신에 정해진 입력 데이터에서
        // 객체를 만드는 정적 메서드 사용
        SampleData testData = new SampleData();
        String[] fields = text.split("\t");
        
        testData.date = fields[0];
        testData.size = Integer.parseInt(fields[1]);
        testData.weight = Integer.parseInt(fields[2]);
        testData.design = Integer.parseInt(fields[3]);
        testData.battery = Integer.parseInt(fields[4]);
        testData.soundQuality = Integer.parseInt(fields[5]);
        testData.price = Integer.parseInt(fields[6]);
        testData.display = Integer.parseInt(fields[7]);
        testData.velocity = Integer.parseInt(fields[8]);
        
        return testData;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.date + "\t");
        sb.append(this.size + "\t");
        sb.append(this.weight + "\t");
        sb.append(this.design + "\t");
        sb.append(this.battery + "\t");
        sb.append(this.soundQuality + "\t");
//        sb.append(this.price + "\t");
        sb.append(this.display + "\t");
        sb.append(this.velocity);
        
        return sb.toString();
    }
    
    public String getDate()
    {
        return date;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void setSize(int size)
    {
        this.size = size;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    
    public int getDesign()
    {
        return design;
    }
    
    public void setDesign(int design)
    {
        this.design = design;
    }
    
    public int getBattery()
    {
        return battery;
    }
    
    public void setBattery(int battery)
    {
        this.battery = battery;
    }
    
    public int getSoundQuality()
    {
        return soundQuality;
    }
    
    public void setSoundQuality(int soundQuality)
    {
        this.soundQuality = soundQuality;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    public int getDisplay()
    {
        return display;
    }
    
    public void setDisplay(int display)
    {
        this.display = display;
    }
    
    public int getVelocity()
    {
        return velocity;
    }
    
    public void setVelocity(int velocity)
    {
        this.velocity = velocity;
    }
    
    public int getThickness()
    {
        return thickness;
    }
    
    public void setThickness(int thickness)
    {
        this.thickness = thickness;
    }
}
