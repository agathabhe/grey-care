<template id="barratitulo">
  <header id="mainheader">
    <p></p>
    <span id="cabecalho">
      &nbsp; Seja bem vindo(a), {{nomeusuario.split(' ')[0]}}!
      <span style="margin-left: 35%">
      <a href="index.html" id="buttonLink">
        <button class="btn btn-danger my-2 my-sm-6" type="button" id="sair">Sair</button>
      </a>
      </span>
    </span>
    <p style="margin-bottom: 15px"></p>
  </header>
</template>

<script>
module.exports = {
  name: "barratitulo",
  props: ["nomeusuario"]
};
</script>
