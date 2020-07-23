package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/2/7
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(SeasonTest1.A1);
        System.out.println(SeasonTest2.A1);
        System.out.println(SeasonTest2.A1.getClass().getSuperclass());
    }
}

enum SeasonTest2{
    A1("A1", "A1 desc"),
    A2("A2", "A2 desc"),
    A3("A3", "A3 desc"),
    A4("A4", "A4 desc");

    private final String seasonName;
    private final String seasonDesc;

    SeasonTest2(String seasonName, String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }
}


class SeasonTest1{

    private final String seasonName;
    private final String seasonDesc;

    private SeasonTest1(String seasonName, String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    public static final SeasonTest1 A1 = new SeasonTest1("A1", "A1 desc");
    public static final SeasonTest1 A2 = new SeasonTest1("A2", "A2 desc");
    public static final SeasonTest1 A3 = new SeasonTest1("A3", "A3 desc");
    public static final SeasonTest1 A4 = new SeasonTest1("A4", "A4 desc");

    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "SeasonTest1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
