`use strict`

import * as DOM from '../dom.js';

const writeItem = item => {
  const child = document.createElement(`li`);
  child.id = item._id;
  child.innerHTML = `<b>ID: ${item.id}</b> <br> Artist: ${item.artist}<br> Album: ${item.album}<br> Size: ${item.size} <br><br>`;
  DOM.listOutput.appendChild(child);
}
const getArtist = (artist) => {
  DOM.artistOutput.innerHTML = ``;

  axios.get(`http://localhost:8080/getByArtist/${artist}`)
    .then((response) => {
      if (!Array.isArray(response.data)) {
        writeItem(response.data);
      } else {
        for (let item of response.data) {
          writeItem(item);
        }
      }
    }).catch((err) => {
      console.log(err);
    });
}
DOM.buttonArtist.onclick = () => getArtist(DOM.inputFindArtist.value);