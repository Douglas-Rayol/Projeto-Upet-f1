<?php
    require_once "../util/config.php";

    $sql = "SELECT * FROM cliente ORDER BY nome";
    $result = mysqli_query($link, $sql);

?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exibir Produto</title>
    <link rel="stylesheet" href="../css/clien-func.css">
    <link rel="shortcut icon" href="../upet.ico">
    <link rel="stylesheet" type="text/css" href="../css/staff.css">
</head>
<body>
    <div class="menu">
        <div class="logo-tabela">
            <img src="../img/logo_upet.png" />
            STAFF
        </div>
        <div class="secoes">
            <li><a href="../produto/index.php">Produtos</a></li>
            <div class="selecionado"><li><a href="../cliente/index.php">Clientes</a></li></div>
            <li><a href="../funcionario/index.php">Funcionários</a></li>
        </div>
    </div>
<div class="tela-banco">

    <div class="tabela-banco">
    <h2>Lista de Cliente</h2>
    <p><a href="create.php">Incluir</a></p>
    <table border="0">
        <tr class="tabela-titulo">

            <td><center>Nome</center></td>
            <td><center>Telefone</center></td>
            <td><center>E-mail</center></td>
            <td><center>Endereço</center></td>
            <td colspan="3"><center>Ações</center></td>
        </tr>
        <?php while($row = mysqli_fetch_array($result)){?>
        <tr class="tabela-linha">
            
            <td><?php echo($row['nome'])?></td>
            <td><?php echo($row['telefone'])?></td>
            <td><?php echo($row['email'])?></td>
            <td><?php echo($row['endereco'])?></td>
            <td><?php echo('<a href="read.php?id='.$row['idcliente'].'">Exibir</a>')?></td>
            <td><?php echo('<a href="update.php?id='.$row['idcliente'].'">Alterar</a>')?></td>
            <td><?php echo('<a href="delete.php?id='.$row['idcliente'].'">Excluir</a>')?></td>
        </tr>
        <?php } ?>
    </table>
    </div>
</div>
</body>
</html>