<?php
    session_start();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>uPet Alimentos</title>
    <link rel="shortcut icon" href="upet.ico">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/estilo.css" />
    <link rel="shortcut icon" href="../upet.ico">
</head>
<body>
    <header>
        <main>
            <div class="logo">
                <a href="../index.php"><img src="../img/logo_upet.png" /></a>
            </div>
            <div class="buscar">
                <input type="text" placeholder="Pesquisar na Upet" />
                <img src="../img/buscar.png" />
            </div>
            <div class="conta"><a href="../login/login.php" class="conta">
                <img src="../img/profile.png" />
                Olá <?php 
                    require_once "../util/config.php";

                    $sql = "SELECT * FROM funcionario";
                    $result = mysqli_query($link, $sql);
                    $contador = 0;
                    while($row = mysqli_fetch_array($result)){
                        if($row['idfuncionario'] == "3"){
                            echo $row['nome'];
                ?></a>
            </div>
        </main>
        <div class="secoes">
            <ul>
                <li><a href="alimentos.php">Alimentos</a></li>
                <li><a href="acessorios.php">Acessórios</a></li>
                <li><a href="brinquedos.php">Brinquedos</a></li>
                <li><a href="higiene.php">Saúde e Higiene</a></li>
            </ul>
        </div>
    </header>

    <div class="dados-container">
        <div class="dados-titulo">Meus Dados</div>
        <div class="dados">
        <div class="dados-texto">Nome:</div>
            <?php echo $row['nome']; ?>
        </div>
        <div class="dados">
        <div class="dados-texto">Endereço:</div>
            <?php echo $row['endereco']; ?>
        </div>
        <div class="dados">
        <div class="dados-texto">Telefone:</div>
            <?php echo $row['telefone']; ?>
        </div>
        <div class="dados">
            <div class="dados-texto">Email:</div>
            <?php echo $row['email']; ?>
        </div>
        <?php       }
                }
        ?>
    </div>

    <div class="perfil-container">
        <div class="meus-pets">Meus Pets</div>
        <div class="pets-container">
            <a href="cadastro-pet"><div class="pet">
                <div class="mais-pet">+</div>
                <div class="texto-pet">Adicionar novo pet</div>
            </div></a>
            <a href="cadastro-pet"><div class="pet">
                <div class="mais-pet">+</div>
                <div class="texto-pet">Adicionar novo pet</div>
            </div></a>
            <a href="cadastro-pet"><div class="pet">
                <div class="mais-pet">+</div>
                <div class="texto-pet">Adicionar novo pet</div>
            </div></a>
        </div>
    </div>

    <div class="rodape-cor">
    <div class="rodape-posicao">
        <div class="rodape-dados">
            <div class="rodape-logo">
                <ul>
                    <li><img src="../img/logo_upet.png" /></li>
                    <li>Upet 2022. Todos os Direitos reservados</li>
                    <li>Desenvolvido por MELD</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
