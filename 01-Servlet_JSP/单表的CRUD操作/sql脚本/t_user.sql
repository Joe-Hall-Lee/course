DROP TABLE
IF
	EXISTS t_user;
CREATE TABLE t_user ( id INT PRIMARY KEY auto_increment, username VARCHAR ( 255 ), password VARCHAR ( 255 ) );
INSERT INTO t_user ( username, password )
VALUES
	( 'admin', '123456' );
INSERT INTO t_user ( username, password )
VALUES
	( 'zhangsan', '123456' );
COMMIT;
SELECT
	* 
FROM
	t_user;