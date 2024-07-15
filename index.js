function startGame(){
    let menu = document.getElementById("menu");
    let game = document.getElementById("game");
    game.style.width = "80%";
    game.style.width = "60%";
    let gameBoard = document.getElementById("gameBoard");
    let columns = Math.trunc(document.getElementById("columns").value);
    columns = columns <= 100 ? columns : 100;
    let rows = Math.trunc(document.getElementById("rows").value);
    rows = rows <= 100 ? rows : 100;
    let actionSelector = document.getElementById("actionSelector");
    actionSelector.style.display = "none";
    if(columns === "" || rows === ""){
        alert("Please give column and row values");
        return;
    } else if(columns < 3 || rows < 3){
        alert("Please provide column and row numbers that are both greater than or equal to 3");
        return;
    }
    alert(columns + " by " + rows + " Minesweeper game started! Enjoy the game!");
    game.style.display = "block";
    menu.style.display = "none";
    let map = [];
    gameBoard.style.gridTemplateColumns = `repeat(${columns})`;
    gameBoard.style.gridTemplateRows = `repeat(${rows})`;
    gameBoard.style.width = `calc(${rows} * 100px)`;
    gameBoard.style.height = `calc(${columns} * 100px)`;
    for(let i = 0; i<rows; i++){
        map[i] = [];
        for(let j = 0; j<columns; j++){
            if((j+i)%2 == 0){
                map[i][j] = elementFromHTML(`
                <div id="gameTileDark" style="grid-row: ${j} / ${j+1}; grid-column: ${i} / ${i+1}">

                </div>
                `);
            } else{
                map[i][j] = elementFromHTML(`
                <div id="gameTileLight" style="grid-row: ${j} / ${j+1}; grid-column: ${i} / ${i+1}">

                </div>
                `);
            }
            gameBoard.appendChild(map[i][j])
            alert('tile placed at ' + j +', ' + i)
        }
    }
    alert(gameBoard)
    console.error(gridSize);
    var gridWidth = "" + gridSize*columns + "vw";
    var gridHeight = "" + 100*rows + "vw";
    game.style.width = gridWidth + 80;
    game.style.height = gridHeight + 80;
}

function runGame(map){
    var board = document.getElementById("game");


}

function elementFromHTML(html){
    const template = document.createElement("template");
    template.innerHTML = html.trim();
    return template.content.firstElementChild;
}

function openSelector(tile){

    alert("selector opened");
    var selector = document.getElementById("actionSelector");
    selector.style.display = "block";
    var y = tile.style.top + 10;
    var x = tile.style.left + 10;
}

function dig(){

    closeSelector();
}

function flag(){

    closeSelector();
}
function closeSelector(){
    var selector = document.getElementById("actionSelector");
    selector.style.display = "none";
}