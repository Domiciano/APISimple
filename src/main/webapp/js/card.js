class Card{
    //Nombre usuario y teléfono


    constructor(user) {
        this.user = user;
        this.delete = null;
    }


    //Methods class

    //Nos permite dibujar el componente
    render = (container)=>{

        //1. Primera forma. Armar un lego
        /*
        let div = document.createElement('div'); //<div></div>
        let p = document.createElement('p'); //<p></p>
        let small = document.createElement('small'); //<small></small>

        p.innerHTML = this.user.nombre;
        small.innerHTML = this.user.tel;

        div.appendChild(p);
        div.appendChild(small);
        //<div><p>Alberto</p><small>273429834</small></div>
        container.appendChild(div);
        */

        //2. Con el HTML
        let html =  "<div class='card'>" +
                        "<p>"+this.user.nombre+"</p>" +
                        "<small>"+this.user.tel+"</small>" +
                        "<button class='deletebtn' id='delete"+this.user.id+"'>X</button>"+
                    "</div>";


        let div = document.createElement('div');
        div.innerHTML = html;
        container.appendChild(div);


        //Acciones interactivas
        let button = document.getElementById('delete'+this.user.id);
        button.addEventListener('click', ()=>{
            this.delete(this);
        });



    }



}


