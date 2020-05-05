package com.android.unitconverter;

public class Unit {
    private String mUnit;
    private int mUnitPhoto;

    public Unit(int unitPhoto, String unit) {
        mUnitPhoto = unitPhoto;
        mUnit = unit;
    }

    public int getUnitPhoto(){
        return mUnitPhoto;
    }

    public String getUnit() {
        return mUnit;
    }
}
