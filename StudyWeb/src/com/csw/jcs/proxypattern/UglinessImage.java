package com.csw.jcs.proxypattern;

public class UglinessImage implements IImage {

    private String fileName;

    public UglinessImage(String fileName) {
        this.fileName = fileName;
        System.out.println("Loading 。。。" + fileName);
    }


    @Override
    public void cutePaly() {
        System.out.println(fileName + "  cutePlay");
    }
}
