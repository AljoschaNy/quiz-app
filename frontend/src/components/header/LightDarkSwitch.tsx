import SunIcon from "../icons/SunIcon.tsx";
import MoonIcon from "../icons/MoonIcon.tsx";
import "./LightDarkSwitch.css";
import {useEffect, useState} from "react";

function LightDarkSwitch() {
    const systemPrefersDark: boolean = window.matchMedia && window.matchMedia("(prefers-color-scheme: dark)").matches;
    const initialIsChecked: boolean = document.documentElement.classList.contains("dark") || systemPrefersDark;
    const [isChecked,setIsChecked] = useState<boolean>(initialIsChecked);

    useEffect(() => {
        if(isChecked) {
            document.documentElement.classList.remove("light");
            document.documentElement.classList.add("dark");
        } else {
            document.documentElement.classList.remove("dark");
            document.documentElement.classList.add("light");
        }
    }, [isChecked])

    function handleClick() {
        setIsChecked(!isChecked);
    }


    return (
        <div className={"toggle-switch-container"}>
            <SunIcon />
            <label className={"switch"}>
                <input type={"checkbox"} checked={isChecked} onClick={handleClick}/>
                <span className={"slider"}></span>
            </label>
            <MoonIcon />
        </div>

    );
}

export default LightDarkSwitch;
