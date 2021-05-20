let container = document.getElementById('container');


let cards = [];


let card = new Card({
    id:'alfa',
    nombre:'Morty',
    tel:'23649234'
});
card.delete = (card) => {
    let index = cards.indexOf(card);
    cards.splice(index,1);
    showAll();
}

let card2 = new Card({
    id:'beta',
    nombre:'Rick',
    tel:'234343112'
});
card2.delete = (card) => {
    let index = cards.indexOf(card);
    cards.splice(index,1);
    showAll();
}

cards.push(card);
cards.push(card2);


const showAll = ()=>{
    container.innerHTML = "";
    for(let i = 0; i<cards.length ; i++){
        let c = cards[i];
        c.render(container);
    }
}

showAll();
