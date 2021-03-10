import axios from 'axios'

const url = 'http://localhost:5050/Users'   //first run json server,
                                                    //run ngrok http 5050, 
                                                    //change the url

export const getLists = (id) =>  axios.get(`${url}/${id}`)
export const createList = (newList) => axios.post(url, newList)