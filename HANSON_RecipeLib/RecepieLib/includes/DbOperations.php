<?php
    class DbOperations{
   
    private $con;

    function __construct(){

        require_once dirname(__FILE__).'/DbConnect.php';

        $db = new DbConnect();

        $this->con = $db->connect();
        
    }

    /*CRUD CREATE*/
    function createUser($email, $username, $pass){
        $password = md5($pass);
        $stmt = $this->con->prepare("INSERT INTO `users` (`id`, `email`, `username`, `password`) 
        VALUES (NULL, ?, ?, ?);");
        $stmt->bind_param('sss', $email, $username, $password);

        if($stmt->execute()){
            return true;
        }
        else{
            return false;
        }
    }
    }