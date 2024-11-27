// User Interactivity
const feedbackAdd = document.getElementById("feedbackAdd") as HTMLElement;
const feedbackError = document.getElementById("feedbackError") as HTMLElement;
const feedbackDelete = document.getElementById("feedbackDelete") as HTMLElement;
const feedbackDeleteChore = document.getElementById("feedbackDeleteChore") as HTMLElement;
const choreContainer = document.getElementById("choreContainer") as HTMLElement;
const choreDisplay = document.getElementById("choreDisplay") as HTMLElement;
const emptyText = document.getElementById("emptyText") as HTMLElement;

// Buttons
const sendBtn = document.getElementById("sendBtn") as HTMLElement;
const deleteBtn = document.getElementById("deleteBtn") as HTMLElement;
const deleteChore = document.getElementById("deleteChore") as HTMLElement;
const searchBtn = document.getElementById("searchBtn") as HTMLElement;

// Values
const title = document.getElementById("title") as HTMLInputElement;
const date = document.getElementById("date") as HTMLInputElement;
const text = document.getElementById("text") as HTMLInputElement;
const searchInput = document.getElementById("searchInput") as HTMLInputElement;
const keyName = "task";
const keyDate = "date";
const keyText = "text";
const keyChores = "chores";
let localCont: number;

// Creates a chore each time
function createChores(title: string, date: string, text: string, choresCounter: number) {
    const newChore = document.createElement("div");
    const newContainerTask = document.createElement("div");
    const newSeparator = document.createElement("div");
    const newSeparator2 = document.createElement("div");
    const newTitle = document.createElement("h1");
    const newDate = document.createElement("p");
    const newParagraph = document.createElement("h2");
    const newButton = document.createElement("button");

    newChore.className = "display-chores";
    newSeparator.className = "separator";
    newSeparator2.className = "separator-bottom";
    newContainerTask.className = "text-display";
    newContainerTask.id = "task" + String(choresCounter);
    newTitle.innerText = title;
    newDate.innerText = text;
    newParagraph.innerText = date;
    newButton.className = "btn delete";
    newButton.id = "deleteNewChore" + Number(choresCounter);
    newButton.innerText = "Delete";

    newChore.appendChild(newContainerTask);
    newContainerTask.appendChild(newSeparator);
    newContainerTask.appendChild(newSeparator2);
    newSeparator.appendChild(newTitle);
    newSeparator.appendChild(newParagraph);
    newSeparator2.appendChild(newButton);
    newSeparator2.appendChild(newDate);

    if (choreContainer) {
        choreContainer.appendChild(newChore);
    }

    newButton.addEventListener("click", () => {
        handleDelete(choresCounter, newChore);
    });

    taskSearcher(title, choresCounter, newContainerTask);
}

// Removes a specific task
function handleDelete(choresCounter: number, newChore: HTMLElement) {
    newChore.remove();
    let k = choresCounter;

    localStorage.removeItem(keyName + k);
    localStorage.removeItem(keyDate + k);
    localStorage.removeItem(keyText + k);
    localStorage.setItem(keyChores, String(choresCounter - 1));

    popupDisplay(feedbackDeleteChore);
}

// Only displays the task that the user searched for (not finished)
function taskSearcher(title: string, id: number, newContainerTask: HTMLElement) {
    /*const titleId = "task" + id;
    let array: string[] = [];
    array.push(title);*/

    // TO-DO
}

// Checks if the local storage is empty
function localStorageCheck() {
    let booleanCheck: boolean;

    if (!localStorage.getItem(keyName + 1)) {
        localCont = 0;
        booleanCheck = false;
    }
    else {
        let k = 0;
        let displayEmpty = "none";

        while (localStorage.getItem(keyName + (k + 1))) {
            createChores(
                String(localStorage.getItem(keyName + (k + 1))),
                String(localStorage.getItem(keyText + (k + 1))),
                String(localStorage.getItem(keyDate + (k + 1))), k + 1);
            k++;
            displayEmpty = "flex";
        }

        if (emptyText) {
            emptyText.style.display = displayEmpty;
        }

        localStorage.setItem(keyChores, String(k));
        booleanCheck = true;
    }

    return booleanCheck;
}

// Makes the popup display on the screen
function popupDisplay(type: HTMLElement) {
    type.style.display = "flex";

    setTimeout(() => {
        type.style.display = "none";
    }, 3000);
}

localStorageCheck();

sendBtn?.addEventListener("click", () => {
    if (title.value && date.value) {
        localCont = Number(localStorage.getItem(keyChores));
        localCont++;

        localStorage.setItem(keyName + String(localCont), title.value);
        localStorage.setItem(keyDate + String(localCont), date.value);
        localStorage.setItem(keyText + String(localCont), text.value);
        localStorage.setItem(keyChores, String(localCont));

        popupDisplay(feedbackAdd);
        title.style.border = "none";
        date.style.border = "none";
        text.style.border = "none";
        createChores(title.value, date.value, text.value, Number(localStorage.getItem(keyChores)));

        // Resets input value
        title.value = "";
        date.value = "";
        text.value = "";
    }
    else {
        popupDisplay(feedbackError);
        title.style.border = "2px solid red";
        date.style.border = "2px solid red";
        text.style.border = "2px solid red";
    }
});

deleteBtn?.addEventListener("click", () => {
    localStorage.clear();
    choreDisplay.style.display = "none";
    popupDisplay(feedbackDelete);

    localStorageCheck();
});

searchBtn?.addEventListener("click", () => {
    const input = searchInput.value;

    if (localStorage.getItem(keyName + 1)) {
        for (let k = 1; k <= Number(localStorage.getItem(keyChores)); k++) {
            if (localStorage.getItem(keyName + k) === input) {
                // TO-DO
            }
        }

    }
});