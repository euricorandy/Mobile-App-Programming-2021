<?php
ini_set('mysql.connect_timeout', 300);
ini_set('default_socket_timeout', 300);

    class DbConnect{
        private $con;

        function __construct(){

        }

        function connect(){
            include_once dirname(__FILE__).'/Constants.php';
            $this->con = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);
        
            if(mysqli_connect_error()){
                echo "Failed to connect with database".mysqli_connect_err();
            }

            return $this->con;
        }
    }