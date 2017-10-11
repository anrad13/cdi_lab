package newlab.cdi.ee7;

/**
 * Created by Game on 11.10.2017.
 */
public enum ErrorCode {

    ERR_0001("0001"),
    ERR_0002("0002"),
    ERR_0003("0003");


    private final String errCode;

    ErrorCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCode() { return errCode; }

}
