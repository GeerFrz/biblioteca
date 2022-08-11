/* Variables globales */
var classLibroFormulario;
var classLibrosListado;
var paginaListado = '/';


/* Funciones globales */
async function SendRequest(url, data={}, init={}){

    init.method = typeof init.method === 'undefined' ? 'POST' : init.method;
    init.headers = typeof init.headers === 'undefined' ? {'Content-Type': 'application/json'} : init.headers;
    init.body = JSON.stringify(data);

    const response = await fetch(url, init);

    let result = {
        type: response.ok ? 'success' : 'error',
        status: response.status,
        message: await response.text()
    };

    return result;
}
