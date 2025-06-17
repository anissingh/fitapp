import 'bootstrap/dist/css/bootstrap.min.css';
import './style.css';
import '../Common/buttons.css';

export const AuthDashboard = () => {
    return (
        <div id="auth-container-wrapper" className="container-fluid">
            <div id="auth-header-container" className="row">
                <h4 className="auth-header-subtitle">Welcome to</h4>
                <h3 className="auth-header-title">FitApp</h3>
            </div>
            <div id="auth-image-container" className="row">

            </div>
            <div id="auth-btn-container" className="row">
                <button className="signup-btn rounded-btn standard-colour-btn">Sign Up For Free</button>
                <button className="login-btn rounded-btn inverted-colour-btn">Log In</button>
            </div>
        </div>
    );
}