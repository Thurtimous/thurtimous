import React from 'react';
import {BrowserRouter as Router, Route, Link, Switch} from 'react-router-dom'

// components
import Header from './components/header/header.js';
import Footer from './components/footer/footer';
import Home from './components/pages/home/home';
import Asset from './components/pages/assets/asset';
import Error404 from './components/pages/error/404';
//CSS includes
import './assets/css/default.min.css'

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Switch>
          <Route exact path='/' component={Home} />
          <Route exact path='/asset' component={Asset} />
          <Route component={Error404} />
        </Switch>
        <Footer />
      </div>
      </Router>
    );

}

export default App;
