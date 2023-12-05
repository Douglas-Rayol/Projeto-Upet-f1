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
        if($_SERVER['REQUEST_METHOD'] == "POST"){        
            $nome = $_POST["nome"];
            $preco = $_POST["preco"];
            $descricao = $_POST["descricao"];
            $id = $_POST["id"];
            $sql = "UPDATE produtos SET nome = ?, preco = ?, descricao = ? WHERE id = ?";
            $stmt = mysqli_prepare($link, $sql);
            mysqli_stmt_bind_param($stmt, "sdss", $nome, $preco, $descricao);
            if(mysqli_stmt_execute($stmt)){
                header('location: index.php');
                exit;
            } else {
                echo "Ocorreu um erro";
            }
        }
    ?>
    <!DOCTYPE html>
    <html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alterar Produtos</title>
        <link rel="stylesheet" href="../css/dea.css">
    </head>
    <body>
    <h2>Alteração de Produtos</h2>
    <form method="post" action="update.php">
        <p>Nome:<input type="text" name="nome" value="<?php echo $row['nome'] ?>"></p>
        <p>Preço:<input type="text" name="preco" value="<?php echo $row['preco'] ?>"></p>
        <p>Descrição:<input type="text" name="descricao" value="<?php echo $row['descricao'] ?>"></p>
        <input type="hidden" name="id" value="<?php echo $row['id'] ?>">
        <p><input type="submit" value="Alterar"></p>
    </form>
    <p><a href='index.php'>Voltar</a></p>
    </body>
    </html>