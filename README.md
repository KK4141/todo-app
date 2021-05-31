# todo-app
JDBCパッケージのインポート
import java.sql.*;

JDBCパッケージのメソッドはjava.sql.SQLException 例外をスローすることがあるので例外処理が必要

JDBCドライバのタイプ
タイプ1	JDBCからODBCを介してデータベースにアクセスするJDBCドライバ
タイプ2	JDBCからデータベース固有のAPIを介してデータベースにアクセスするJDBCドライバ
タイプ3	JDBCから中継サーバを介してデータベースにアクセスするJDBCドライバ
タイプ4	データベース固有のJDBCドライバからデータベースにアクセスする

JDBCドライバを使用するには、ドライバをロードする必要がある
Class.forName() メソッドを使用して、ドライバをロードする

static class forName(String className) throws ClassNotFoundException
引数 className には、クラス名を指定
クラス名は、使用するRDBMSによって異なる

JDBC Driver	クラス名

MySQL	com.mysql.jdbc.Driver

Oracle	oracle.jdbc.driver.OracleDriver

PostgreSQL	org.postgresql.Driver

SQLServer	com.microsoft.sqlserver.jdbc.SQLServerDriver

TimesTen	com.timesten.jdbc.TimesTenDriver

データベースと接続するには、DriverManager.getConnection() メソッドを使用

static Connection getConnection(String url) throws SQLException
static Connection getConnection(String url, String user, String password) throws SQLException
引数 url には、接続URLを指定。接続URLはRDBMSによって異なる

データベースに接続する際にユーザ名とパスワードが必要な場合は、引数 user にユーザ名、引数 password にパスワードを指定

ステートメントの作成
SQL文を実行する前に、SQLステートメントのオブジェクトを作成する必要がある
ステートメントを作成するには、 Connection.createStatement() メソッドを使用

Statement createStatement() throws SQLException
ステートメントを作成する例
Connection conn = DriverManager.getConnection(url);
Statement stmt = conn.createStatement();

INSERT, UPDATE, DELETE などのSQL文を実行するには、 Statement.executeUpdate() メソッドを使用

行を挿入するJavaソース・コードの例
Statement stmt = conn.createStatement();
String sql = "INSERT INTO EMP VALUES ('Yamada')";
ResultSet rset = stmt.executeUpdate(sql);

問い合わせ（クエリ）を行うには、 Statement.executeQuery() メソッドを使用
問い合わせを行うJavaソース・コードの例
Statement stmt = conn.createStatement();
String sql = "SELECT ENAME FROM EMP";
ResultSet rset = stmt.executeQuery(sql);
while (rset.next()) {
    System.out.println(rset.getString(1));
}
rset.close();

データベースと切断するには、 Connection.close() メソッドを使用

JDBCでは、デフォルトで自動コミットが有効
