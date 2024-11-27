"use strict";
// User Interactivity
const calendar = document.getElementById("calendar");
// Buttons
const send = document.getElementById("send");
// Values
const title = document.getElementById("title");
const date = document.getElementById("date");
const keyName = "task";
let keyDate;
let dataCont;
let localCont;
if (!localStorage.getItem(keyName)) {
    dataCont = 1;
}
else {
    //dataCont = Number(localStorage.getItem(String(localCont)));
}
send === null || send === void 0 ? void 0 : send.addEventListener("click", () => {
    if (title.value || date.value) {
        localStorage.setItem(keyName + String(dataCont), title.value);
        localStorage.setItem(keyDate + String(dataCont), date.value);
        dataCont++;
        localCont = dataCont;
    }
});
//# sourceMappingURL=index.js.map