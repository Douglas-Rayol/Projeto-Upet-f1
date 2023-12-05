<?php
    session_start();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loja Upet</title>
    <link rel="stylesheet" type="text/css" href="./css/estilo.css">
    <link rel="shortcut icon" href="./upet.ico">
</head>
<body>
    <header>
        <main>
            <div class="logo">
                <img src="./img/logo_upet.png" />
            </div>
            <div class="buscar">
                <input type="text" placeholder="Pesquisar na Upet" />
                <img src="./img/buscar.png" />
            </div>
            <div class="conta"><a href="./login/login.php" class="conta">
                <img src="./img/profile.png" />
                Minha conta</a>
            </div>
        </main>
        <div class="secoes">
            <ul>
                <li><a href="./user-visitante/alimentos.php">Alimentos</a></li>
                <li><a href="./user-visitante/acessorios.php">Acessórios</a></li>
                <li><a href="./user-visitante/brinquedos.php">Brinquedos</a></li>
                <li><a href="./user-visitante/higiene.php">Saúde e Higiene</a></li>
                <li><a href="./carrinho">Carrinho</a></li>
            </ul>
        </div>
    </header>
    <div class="anuncio">
        <img src="./img/relogio.png" />
        <span class="anuncio-titulo">Assinatura Upet</span>
        <span class="anuncio-subtitulo">10% OFF em todas as suas compras</span>
    </div>

    <!-- Carrossel de Slides -->
    <div class="slider-container">
        <div class="slider">
            <div class="slides">
                <!-- Radio Buttons -->
                <input type="radio" name="radio-btn" id="radio1">
                <input type="radio" name="radio-btn" id="radio2">
                <input type="radio" name="radio-btn" id="radio3">
                <input type="radio" name="radio-btn" id="radio4">
    
                <!-- Slide images -->
                <div class="slide first">
                    <img src="./img/Imagem1.png" alt="Imagem 1" />
                </div>
                <div class="slide">
                    <img src="./img/Imagem2.png" alt="Imagem 2" />
                </div>
                <div class="slide">
                    <img src="./img/Imagem3.png" alt="Imagem 3" />
                </div>
                <div class="slide">
                    <img src="./img/Imagem4.png" alt="Imagem 4" />
                </div>
    
                <!--Navigation auto-->
                <div class="navigation-auto">
                    <div class="auto-btn1"></div>
                    <div class="auto-btn2"></div>
                    <div class="auto-btn3"></div>
                    <div class="auto-btn4"></div>
                </div>
            </div>
    
            <div class="manual-navigation">
                <label for="radio1" class="manual-btn"></label>
                <label for="radio2" class="manual-btn"></label>
                <label for="radio3" class="manual-btn"></label>
                <label for="radio4" class="manual-btn"></label>     
            </div>
        </div>
        <!-- Fim do Carrossel de Slides -->
    </div>

    <div class="avisos">
        <div class="avisos-box">
            <span><img src="./img/relogio.png" /></span>
            <span>Receba em Horas</span>
        </div>
        <div class="avisos-box">
            <span><img src="./img/caminhao.png" /></span>
            <span>Frete Grátis Brasil</span>
        </div>
        <div class="avisos-box">
            <span><img src="./img/cartao.png" /></span>
            <span>Até 10x sem Juros</span>
        </div>
        <div class="avisos-box">
            <span><img src="./img/local.png" /></span>
            <span>Retire e Troque na Loja</span>
        </div>
    </div>

        <!-- ALIMENTOS -->
<div class="produto-texto">
    <div class="produto-titulo">
        <p id="produto-titulo"><img src="./img/Alimentos.png" style="width: 20px; height: 20px;"/> ALIMENTOS</p>
        <p id="produto-descricao">As melhores rações, petiscos e ossos você encontra aqui.</p>
    </div>
</div>
<div class="centro">
        <?php
                require_once "./util/config.php";

                $sql = "SELECT * FROM produtos";
                $result = mysqli_query($link, $sql);
                $contador = 0;
                while($contador <= 5){
                    while($row = mysqli_fetch_array($result)){
                        if($row['tipo'] == "Alimento"){
        ?>
    <div class="produto">
        <div class="box">   
            <div class="img-produto">
                <img src= "<?php echo $row['imagem']; ?>" />
            </div>
            <div class="texto">
                <p id="produto-nome"><?php echo $row['nome']; ?></p>
                <p><?php echo $row['descricao']; ?></p> 
                <p><?php echo $row['preco']; ?></p>
            </div>
        </div>
    </div>
    <?php
                        }$contador += 1;
                    }
                }
    ?>
</div>

    <!-- ACESSÓRIOS -->
<div class="produto-texto">
    <div class="produto-titulo">
        <p id="produto-titulo"><img src="./img/Acessórios.png" style="width: 20px; height: 20px;"/> ACESSÓRIOS</p>
        <p id="produto-descricao">Vestuário, coleiras e tudo que você precisa pro seu pet.</p>
    </div>
</div>
<div class="centro">

        <?php
                require_once "./util/config.php";

                $sql = "SELECT * FROM produtos";
                $result = mysqli_query($link, $sql);
                $contador = 0;
                while($contador <= 5){
                    while($row = mysqli_fetch_array($result)){
                        if($row['tipo'] == "Acessorio"){
        ?>
    <div class="produto">
        <div class="box">   
            <div class="img-produto">
                <img src= "<?php echo $row['imagem']; ?>" />
            </div>
            <div class="texto">
                <p id="produto-nome"><?php echo $row['nome']; ?></p>
                <p><?php echo $row['descricao']; ?></p> 
                <p><?php echo $row['preco']; ?></p>
            </div>
        </div>
    </div>
    <?php
                        }$contador += 1;
                    }
                }
    ?>
</div>

    <!-- BRINQUEDOS -->
    <div class="produto-texto">

        <div class="produto-titulo">
            <p id="produto-titulo"><img src="./img/Brinquedos.png" style="width: 20px; height: 20px;"/> BRINQUEDOS</p>
            <p id="produto-descricao">Mordedores, bolinhas e cabos de guerra.</p>
        </div>
    </div>
    <div class="centro">

        <?php
                require_once "./util/config.php";

                $sql = "SELECT * FROM produtos";
                $result = mysqli_query($link, $sql);
                $contador = 0;
                while($contador <= 5){
                    while($row = mysqli_fetch_array($result)){
                        if($row['tipo'] == "Brinquedo"){
        ?>
    <div class="produto">
        <div class="box">   
            <div class="img-produto">
                <img src= "<?php echo $row['imagem']; ?>" />
            </div>
            <div class="texto">
                <p id="produto-nome"><?php echo $row['nome']; ?></p>
                <p><?php echo $row['descricao']; ?></p> 
                <p><?php echo $row['preco']; ?></p>
            </div>
        </div>
    </div>
    <?php
                        }$contador += 1;
                    }
                }
    ?>
</div>

    <!-- SAÚDE E HIGIENE -->
<div class="produto-texto">
    <div class="produto-titulo">
        <p id="produto-titulo"><img src="./img/Higiene.png" style="width: 20px; height: 20px;"/> SAÚDE E HIGIENE</p>
        <p id="produto-descricao">Medicamentos e artigos de higiene.</p>
    </div>

</div>
<div class="centro">

        <?php
                require_once "./util/config.php";

                $sql = "SELECT * FROM produtos";
                $result = mysqli_query($link, $sql);
                $contador = 0;
                while($contador <= 5){
                    while($row = mysqli_fetch_array($result)){
                        if($row['tipo'] == "Saude e Higiene"){
        ?>
    <div class="produto">
        <div class="box">   
            <div class="img-produto">
                <img src= "<?php echo $row['imagem']; ?>" />
            </div>
            <div class="texto">
                <p id="produto-nome"><?php echo $row['nome']; ?></p>
                <p><?php echo $row['descricao']; ?></p> 
                <p><?php echo $row['preco']; ?></p>
            </div>
        </div>
    </div>
    <?php
                        }$contador += 1;
                    }
                }
    ?>
</div>

<div class="rodape-cor">
    <div class="rodape-posicao">
        <div class="rodape-dados">
            <div class="rodape-logo">
                <ul>
                    <li><img src="./img/logo_upet.png" /></li>
                    <li>Upet 2022. Todos os Direitos reservados</li>
                    <li>Desenvolvido por MELD</li>
                </ul>
            </div>
        </div>
    </div>
</div>


<script>

//Carrossel de Slides
let count = 1;

document.getElementById("radio1").checked = true;

setInterval(function(){
    nextImage();
}, 5000)

function nextImage(){
    count++;
    if(count>4){
        count=1;
    }

    document.getElementById("radio"+count).checked = true;
}
//Fim do Carrossel de Slides    
</script>
</body>
</html>