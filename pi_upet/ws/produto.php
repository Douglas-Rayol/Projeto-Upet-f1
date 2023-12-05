<?php
    include('../util/bancodados.php');

    class Produto{
        public $id;
        public $nome;
        public $descricao;
        public $preco;
        public $tipo;
        public $imagem;

        public function buscarTodos(){
            $bancodados = new BancoDados();
            $bancodados->conectar();
            $lista = array();
            $sql = "SELECT * FROM produtos";
            $resultado = mysqli_query($bancodados->con, $sql);
            if(mysqli_num_rows($resultado) > 0){
                while($row = mysqli_fetch_array($resultado)){
                    $produto = new Produto();
                    $produto->id = $row['id'];
                    $produto->nome = $row['nome'];
                    $produto->descricao = $row['descricao'];
                    $produto->preco = $row['preco'];
                    $produto->tipo = $row['tipo'];
                    $produto->imagem = $row['imagem'];
                    $lista[] = $produto;
                }
            }
            return $lista;
        }
    }
?>
