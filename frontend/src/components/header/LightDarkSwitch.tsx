import SunIcon from "../icons/SunIcon.tsx";
import MoonIcon from "../icons/MoonIcon.tsx";
import "./LightDarkSwitch.css";

function LightDarkSwitch() {
    return (
        <div className={"toggle-switch"}>
            <SunIcon />
            <button>Switch Color</button>
            <MoonIcon />
        </div>

    );
}

export default LightDarkSwitch;
