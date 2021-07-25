# JDBCについて

JDBCパッケージのインポート</br>
import java.sql.*</br>

JDBCパッケージのメソッドはjava.sql.SQLException 例外をスローすることがあるので例外処理が必要

JDBCドライバのタイプ</br>
タイプ1	JDBCからODBCを介してデータベースにアクセスするJDBCドライバ</br>
タイプ2	JDBCからデータベース固有のAPIを介してデータベースにアクセスするJDBCドライバ</br>
タイプ3	JDBCから中継サーバを介してデータベースにアクセスするJDBCドライバ</br>
タイプ4	データベース固有のJDBCドライバからデータベースにアクセスする</br>

JDBCドライバを使用するには、ドライバをロードする必要がある</br>
Class.forName() メソッドを使用して、ドライバをロードする</br>

static class forName(String className) throws ClassNotFoundException</br>
引数 className には、クラス名を指定</br>
クラス名は、使用するRDBMSによって異なる</br>

JDBC Driver	クラス名</br>

MySQL	com.mysql.jdbc.Driver</br>
Oracle	oracle.jdbc.driver.OracleDriver</br>
PostgreSQL	org.postgresql.Driver</br>
SQLServer	com.microsoft.sqlserver.jdbc.SQLServerDriver</br>
TimesTen	com.timesten.jdbc.TimesTenDriver</br>

データベースと接続するには、DriverManager.getConnection() メソッドを使用

static Connection getConnection(String url) throws SQLException</br>
static Connection getConnection(String url, String user, String password) throws SQLException</br>
引数 url には、接続URLを指定。接続URLはRDBMSによって異なる</br>

データベースに接続する際にユーザ名とパスワードが必要な場合は、引数 user にユーザ名、引数 password にパスワードを指定

ステートメントの作成</br>
SQL文を実行する前に、SQLステートメントのオブジェクトを作成する必要がある</br>
ステートメントを作成するには、 Connection.createStatement() メソッドを使用</br>

Statement createStatement() throws SQLException</br>
ステートメントを作成する例</br>
Connection conn = DriverManager.getConnection(url);</br>
Statement stmt = conn.createStatement();</br>

INSERT, UPDATE, DELETE などのSQL文を実行するには、 Statement.executeUpdate() メソッドを使用

行を挿入するJavaソース・コードの例</br>
Statement stmt = conn.createStatement();</br>
String sql = "INSERT INTO EMP VALUES ('Yamada')";</br>
ResultSet rset = stmt.executeUpdate(sql);</br>

問い合わせ（クエリ）を行うには、 Statement.executeQuery() メソッドを使用</br>
問い合わせを行うJavaソース・コードの例</br>
Statement stmt = conn.createStatement();</br>
String sql = "SELECT ENAME FROM EMP";</br>
ResultSet rset = stmt.executeQuery(sql);</br>
while (rset.next()) {</br>
    System.out.println(rset.getString(1));</br>
}</br>
rset.close();</br>

データベースと切断するには、 Connection.close() メソッドを使用

JDBCでは、デフォルトで自動コミットが有効
