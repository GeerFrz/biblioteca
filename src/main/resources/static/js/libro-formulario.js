document.addEventListener("DOMContentLoaded", function(event) {

    classLibroFormulario = new Libro();

    document.getElementById('titulo').focus();
    document.getElementById('btnGuardar').addEventListener("click", function(e){
        e.preventDefault();
        classLibroFormulario.guardar();
    });

});

class Libro {
    async guardar(){
        const result = await SendRequest('/guardar', classLibroFormulario.obtenerDatosLibro());
        alert(result.message);

        if(result.type === 'success'){
            window.location.replace(paginaListado);
        }
    }

    obtenerDatosLibro(){

        let precio = document.getElementById('precio').value;

        if(precio === '' || isNaN(precio)){
            precio = '0';
        }

        return {
            id: document.getElementById('id').value,
            titulo: document.getElementById('titulo').value,
            autor: document.getElementById('autor').value,
            precio: precio,
            fechaLanzamiento: document.getElementById('fechaLanzamiento').value,
        }
    }
}
