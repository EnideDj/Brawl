package com.brawl.game;

public class Map {
    private String name;
    private String location;
    private int start;
    private int end;
    private int length;

    public Map(String name, String location, int start, int end, int length) {
        this.name = name;
        this.location = location;
        this.start = start;
        this.end = end;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getLength() {
        return length;
    }
}