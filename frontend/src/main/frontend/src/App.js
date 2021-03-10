//Style

//Components
import React from 'react'
import HomePage from './components/HomePage/HomePage'
import Header from './components/Header/Header'
import Lists from './components/Lists/Lists'
import Login from './components/Login_SingOut/Login'
//Libraries
import { BrowserRouter as Router, Route, Redirect, Switch } from 'react-router-dom'



const App = () => {
  const client_id = '534704394140-vgqdcmbmel4gn1bfa7g3hd6h70qm5c6m.apps.googleusercontent.com'

  return (
    <Router>
      <Switch>
        <Route exact path='/'>
          <Redirect to='/login' />
        </Route>
        <Route path='/home'>
          <Header />
          <HomePage />
        </Route>
        <Route path='/User/Lists/listName' >
          <Header />
          <Lists />
        </Route>
        <Route path='/LogIn'>
          <Login client_id={client_id}/>
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
