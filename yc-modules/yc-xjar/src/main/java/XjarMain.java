import io.xjar.XCryptos;

/**
 * @description:
 * @author: youcong
 */
public class XjarMain {
    public static void main(String[] args) throws Exception {
        XCryptos.encryption()
                .from("D:\\test\\jar\\test-1.0-SNAPSHOT.jar")
                .use("io.xjar")
                .include("/io/xjar/**/*.class")
                .include("/mapper/**/*Mapper.xml")
                .exclude("/static/**/*")
                .exclude("/conf/*")
                .to("D:\\test\\jar\\test.jar");
    }
}
