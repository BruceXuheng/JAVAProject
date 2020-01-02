package com.csw.jcs.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Auther: liangbl
 * @Date: 2018/12/21 13:06
 * @Description: csdn 复制
 */
public class GZIPUtils {
    /**
     * 使用gzip进行压缩
     */
    public static String compress(String primStr) {
        if (primStr == null || primStr.length() == 0) {
            return primStr;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(primStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
    }

    /**
     * 使用gzip进行解压缩
     */
    public static String uncompress(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed = null;
        String decompressed = null;
        try {
            compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);

            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ginzip != null) {
                try {
                    ginzip.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            try {
                out.close();
            } catch (IOException e) {
            }
        }
        return decompressed;
    }


    public static void main(String[] args) {
        String str =
                "188888888888888888888888444444444444444444444444444444333333333333333333222" +
                        "00|交易成功|9DBBI2||||[{\"orderguid\":\"a0566353-9158-4461-aaaa-925424a9bf8e\",\"myshow\":null,\"projguid\":null,\"projname\":\"青岛．中欧国际城-茂创D7地块\",\"roomguids\":null,\"qsdate\":null,\"amount\":null,\"dsamount\":null,\"ysamount\":null}]|[{\"orderguid\":\"a0566353-9158-4461-aaaa-925424a9bf8e\",\"info\":[{\"feeguid\":\"43925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-1\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"44925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-2\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"45925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-3\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"46925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-16\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"47925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-17\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"48925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-18\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"49925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-21\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"4a925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-4\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"4b925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-5\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"4c925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-6\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"4e925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-8\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"4f925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-9\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"52925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-12\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"53925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-13\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"54925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-14\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"55925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-15\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"56925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-22\",\"amount\":null,\"dsamount\":null,\"ysamount\":null},{\"feeguid\":\"57925eac-3301-ea11-80d8-005056a9823f\",\"itemname\":\"D7-23\",\"amount\":null,\"dsamount\":null,\"ysamount\":null}]}]||*"+
                        "222222222222228888888888888888鑫 森 淼 焱 垚 犇 骉 羴 猋 麤 鱻 贔 掱 劦 晶 磊 毳 畾4444444444444444444444444443333d中文中文腻哿鸢尾花888" +
                        "2222222222222288888888888888884444444444444444444444444443333d中文中文腻哿鸢尾花888" +
                        "2222222222222288888888888888884444444444444444444444444443333d中文中文腻哿鸢尾花888" +
                        "22222222222222888888888888888844飝 刕 叒 壵 尛 孨 歮 惢 皛 嚞 舙 譶 雥 灥 飍 馫 飝 厵 靐 龘 三 众44444444444444444444444443333d中文中文腻哿鸢尾花888" +
                        "2222222222222288888888888888884444444444444444444444444443333d中文中文腻哿鸢尾花888" +
                        "2222222222222288888888888888884444444444444444444444444443333d中文中文腻哿鸢尾花888" +
                        "888888888888866666";
        System.out.println("原字符串：" + str);
        System.out.println("原长度：" + str.length());
        String compress = GZIPUtils.compress(str);
        System.out.println("压缩后字符串：" + compress);
        System.out.println("压缩后字符串长度：" + compress.length());
        String string = GZIPUtils.uncompress(compress);
        System.out.println("解压缩后字符串：" + string);
        System.out.println("解压缩后字符串：" + str);



    }
}
