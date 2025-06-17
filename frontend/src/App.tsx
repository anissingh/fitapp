import './App.css';
import {Auth} from "./pages/auth";
import {BrowserRouter, Route, Routes} from "react-router";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/">
                    <Route path="" element={<Auth />}></Route>
                </Route>
            </Routes>
        </BrowserRouter>
    )
}

export default App;
