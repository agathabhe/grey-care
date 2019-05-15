<template id="menu">
    <div class="col-sm-3  sidenav" style="padding-right: 15px">
        <h2 style="color: white; margin-left: 10px"> Menu</h2>
            <hr>
            <ul class="nav nav-pills nav-stacked" style="margin-left: 10px; margin-bottom: 380px">
                <li class="active"><a href="#" id="linkcolor" v-on:click="escondePacientes()">Página Inicial</a>
                </li>
                <li class="active"><a href="paciente-inserir.html" id="linkcolor" v-on:click="mostrarPacientes()">Pacientes</a></li>
                <!--<li class="acitve"><a href="#" id="linkcolor" class="disabled">Consultas</a></li>-->
            </ul>
            <span style="margin-left: 2%">
                <a class="user-editar.html" id="linkcolor"><img src="../../Images/gears.png"
                        style="width:30px; height: 30px"></img>Alterar meus dados</a>
            </span>
    </div>
</template>

<script>
module.exports = {
name: "menusidebar",
};
</script>