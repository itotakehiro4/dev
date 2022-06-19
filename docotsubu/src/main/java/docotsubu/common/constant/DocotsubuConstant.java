package docotsubu.common.constant;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DocotsubuConstant {

  /**
   * セッションアトリビュート
   */
  public static final String SESSION_ATTRIBUTE_PREX = "DOCOTSUBU_";

  public static final class DATE_FORMAT {
    public static final DateTimeFormatter YYYYMMDD =
        DateTimeFormatter.ofPattern("yyyyMMdd").withResolverStyle(ResolverStyle.STRICT);

    public static final DateTimeFormatter YYYYMMDDHHMMSSSSS =
        DateTimeFormatter.ofPattern("yyyyMMddHHmmsssss").withResolverStyle(ResolverStyle.STRICT);

  }

  /**
   * 処理ID
   * 
   * @author t_ito
   *
   */
  public static final class procIds {
    public static final String SYS001 = "sys001";
  }

  /**
   * ログイン
   * 
   * @author t_ito
   *
   */
  public static final class Sys001 {
    public static final String SOLT = "docotsubu";
    public static final String HashNet5 = "Net5";
  }
}
