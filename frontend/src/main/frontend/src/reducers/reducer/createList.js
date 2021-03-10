import {CREATE, FETCH_ALL} from '../../actions/actionTypes'

export default (lists = [], action) => { //where action constains the payload/data thats going to the Store
    switch (action.type){
        case CREATE:
            return [...lists, action.payload]
        case FETCH_ALL: //get the lists of users
            console.log("Payload: " + action.payload)
            return action.payload.lists
        default:
            return lists
    }       
}