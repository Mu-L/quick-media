package com.github.hui.quick.plugin.base.io;

import java.io.*;
import java.util.stream.Collectors;

/**
 * Created by @author yihui in 19:55 19/11/7.
 */
public class IoUtil {

    /**
     * 转换为字节数组输入流，可以重复消费流中数据
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static ByteArrayInputStream toByteArrayInputStream(InputStream inputStream) throws IOException {
        if (inputStream instanceof ByteArrayInputStream) {
            return (ByteArrayInputStream) inputStream;
        }

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            BufferedInputStream br = new BufferedInputStream(inputStream);
            byte[] b = new byte[1024];
            for (int c; (c = br.read(b)) != -1; ) {
                bos.write(b, 0, c);
            }
            // 主动告知回收
            b = null;
            br.close();
            inputStream.close();
            return new ByteArrayInputStream(bos.toByteArray());
        }
    }

    // 将InputStream的内容读取到String中进行打印
    public static String readToString(InputStream inputStream) throws IOException {
        ByteArrayInputStream bis = toByteArrayInputStream(inputStream);
        return new BufferedReader(new InputStreamReader(bis)).lines().collect(Collectors.joining("\n"));
    }
}
