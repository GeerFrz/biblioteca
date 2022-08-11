document.addEventListener("DOMContentLoaded", function(event) {

    classLibroListado = new LibroListado();
    classLibroListado.habilitarBorrado();

});

class LibroListado {
    // anchorBorrar
    habilitarBorrado(){
        const botones = document.querySelectorAll('.anchorBorrar');

        botones.forEach(function(anchor){
            anchor.addEventListener('click', classLibroListado.confirmarBorrado);
        });
    }

    confirmarBorrado(event){
        const titulo = event.target.parentElement.dataset.titulo;
        let result = window.confirm('¿Desea eliminar el libro ' + titulo + '?');

        if(result){
            const accionUrl = event.target.parentElement.dataset.accion;
            classLibroListado.borrarLibro(accionUrl);
        }
    }

    async borrarLibro(accionUrl){

        const result = await SendRequest(accionUrl, null, {method: 'DELETE'});

        if(result.type === 'success'){
            alert('Libro eliminado.');
            window.location.replace(paginaListado);
        } else {
            console.log(result);
            alert('Error: No fue posible eliminar el libro.');
        }
    }
}