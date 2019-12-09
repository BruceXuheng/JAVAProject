package com.csw.jcs.proxypattern;

public class ProxyUglinessImage {

    private UglinessImage uglinessImage;
    private String mFileName;

    public ProxyUglinessImage(String mFileName) {
        this.mFileName = mFileName;
    }

    public void display() {
        if(!mFileName.isEmpty()){
            uglinessImage = new UglinessImage(mFileName);
        }
        uglinessImage.cutePaly();
    }


    public static void main(String[] args) {
        ProxyUglinessImage image = new ProxyUglinessImage("Beautiful Image");
        image.display();

    }

}
