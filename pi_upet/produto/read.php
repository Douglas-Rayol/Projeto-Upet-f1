<?php
    require_once "../util/config.php";

    if($_GET['id']){
        $id = $_GET['id'];
        $sql = "SELECT * FROM produtos WHERE id = ?";
        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $id);
        mysqli_stmt_execute($stmt);
        $result = mysqli_stmt_get_result($stmt);
        $row = mysqli_fetch_array($result);
    }

?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalhe do Produto</title>
</head>
<body>
    <h2>Detalhes do Produto</h2>
    <p>Nome: <?php echo($row['nome']) ?></p>
    <p>Preço: <?php echo($row['preco']) ?></p>
    <p>Descrição: <?php echo($row['descricao']) ?></p>
    <p><a href='index.php'>Voltar</a></p>
</body>
</html>