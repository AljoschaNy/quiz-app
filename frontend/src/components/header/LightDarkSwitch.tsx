import SunIcon from "../icons/SunIcon.tsx";
import MoonIcon from "../icons/MoonIcon.tsx";
import "./LightDarkSwitch.css";

function LightDarkSwitch() {
    return (
        <div className={"toggle-switch-container"}>
            <SunIcon />
            <label className={"switch"}>
                <input type={"checkbox"}/>
                <span className={"slider"}></span>
            </label>
            <MoonIcon />
        </div>

    );
}

export default LightDarkSwitch;
