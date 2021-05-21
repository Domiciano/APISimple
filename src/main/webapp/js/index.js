let container = document.getElementById('container');


let cards = [];


const showAll = ()=>{
    container.innerHTML = "";
    for(let i = 0; i<cards.length ; i++){
        let c = cards[i];
        c.render(container);
        c.delete = (card) => {
            let index = cards.indexOf(card);
            cards.splice(index,1);
            showAll();
        }
    }
}

showAll();

const downloadData = () => {
    var xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function() {
        if(this.readyState === 4) {
            //String (JSON) ->  Object
            let estudiantes = JSON.parse(this.responseText);
            console.log(estudiantes);

            for(let i=0 ; i<estudiantes.length ; i++){
                let estudianten = estudiantes[i];

                let card = new Card({
                    id:estudianten.id,
                    nombre:estudianten.nombre,
                    codigo:estudianten.codigo
                });

                cards.push(card);
            }
            showAll();

        }
    });
    xhr.open("GET", "api/estudiante/all");
    xhr.send();
}

downloadData();
