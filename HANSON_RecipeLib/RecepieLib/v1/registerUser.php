<?php
require_once '../includes/DbOperations.php';

$response = array();

if($_SERVER['REQUEST_METHOD']=='POST'){
    if(isset($_POST['email']) and 
        isset($_POST['username']) and 
            isset($_POST['password']))
    {
        $db = new DbOperations();

        if($db->createUser(
            $_POST['email'], 
            $_POST['username'], 
            $_POST['password']
            )){
                $response['error'] = false;
                $response['message'] = "User register Successfully";
            }
        else {
            $response['error'] = true;
            $response['message'] = "Some error occured please try again";
        }
    }
    else{
        $response['error'] = true;
        $response['message'] = "Required fields are missing";
    }
}else{
    $response['error'] = true;
    $response['message'] = "Invalid Request";
}

echo json_encode($response);