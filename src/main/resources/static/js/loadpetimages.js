console.log("loadpetimages.js loaded \nreadying images...");

// start the script on page load
window.onload = init();

// the function to execute on page load
function init() {
    // grab the names of the pets
    var names = document.querySelectorAll("[id='pet-name']");
    var images = document.querySelectorAll("[id='pet-image']");

    // for each pet found, get a new image path
    for (var i = 0; i < names.length; i++) {
        console.log("pet  " + i + " name: " + names[i].innerHTML);
        // use a function to grab the pet's online image path
        let imgPath = getOnlinePath(names[i].innerHTML);

        // set the image's path to th online resource instead
        images[i].src = imgPath;
    }

//    // grab the name of the pet and the element to inject the path
//    const petName = document.getElementById("pet-name").innerHTML;
//    const petImage = document.getElementById("pet-image");
//    console.log(petName);
//    console.log(petImage);
//
//    // use a function to grab the pet's image path
//    let imgPath = getOnlinePath(petName);
//    console.log(imgPath);
//
//    // set the image's path to an online resource instead
//    petImage.src = imgPath;
}

function getOnlinePath(name) {
    switch(name) {
        case "Celestia":
            return "https://derpicdn.net/img/view/2013/5/5/317234.gif";
        case "Chrysalis":
            return "https://derpicdn.net/img/view/2013/5/5/317300.gif";
        case "Silverstream":
            return "https://derpicdn.net/img/view/2020/11/11/2486607.gif";
        case "Spike":
            return "https://derpicdn.net/img/view/2012/10/14/122186.gif";
        case "Sunset":
            return "https://derpicdn.net/img/view/2020/6/7/2368143.gif";
        case "Twilight":
            return "https://derpicdn.net/img/view/2013/5/5/317231.gif";
        default:
            return "no-img";
    }
}