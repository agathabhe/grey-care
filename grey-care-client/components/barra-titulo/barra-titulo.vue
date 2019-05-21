<template id="barratitulo">
  <header id="mainheader">
    <p></p>
    <span id="cabecalho">
      &nbsp; Seja bem vindo(a), {{nomeusuario}}! &nbsp; &nbsp; &nbsp;
      <a href="#" @click="logout" id="buttonLink" >
        <button class="btn btn-danger my-2 my-sm-6" type="button" id="sair">Sair</button>
      </a>
    </span>
    <p style="margin-bottom: 15px"></p>
  </header>
</template>

<script>
module.exports = {
  name: "barratitulo",
  props: ["nomeusuario"],
  methods: {
    logout: function() {
      this.$session.destroy();
      location.href = "index.html";
    }
  }
};
</script>
