import './App.css';
import {Home} from "./pages/home";
import {BrowserRouter, Route, Routes} from "react-router";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/">
                    <Route path="" element={<Home />}></Route>
                </Route>
            </Routes>
        </BrowserRouter>
    )
}

export default App;
