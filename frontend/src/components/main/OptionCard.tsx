import "./OptionItem.css";
import {OptionCardProps} from "../../types/types.ts";

function OptionCard({ isSelected, quizAnswer, optionText, onClick }: Readonly<OptionCardProps>) {

    return (
        <div className={"option-container"}>
            <button className={isSelected ? "option-card active-option" : "option-card"} onClick={onClick}>
                <span className={"quiz-answer"}>{quizAnswer}</span>
                <span className={"option-text"}>{optionText}</span>
            </button>
        </div>
    )
}

export default OptionCard;