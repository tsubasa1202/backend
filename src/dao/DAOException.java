package dao;

/**
 * DAOで利用する独自例外クラス
 *
 * 
 *
 */
public class DAOException extends Exception {
    public DAOException(String message) {
        super(message);
    }
    public DAOException() {
        super();
    }
}
