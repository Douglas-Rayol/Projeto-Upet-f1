<?php
    include('produto.php');
    $produto = new Produto();

    $lista = $produto->buscarTodos();
    $quant = count($lista);

    if($quant > 0){
        echo json_encode($lista);
    } else {
        http_response_code(404);
        echo json_encode(array("message"=>"Consulta sem resultado"));
    }

?>