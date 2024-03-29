import "./OptionItem.css";
import {useNavigate} from "react-router-dom";
import {TopicCardProps} from "../../types/types.ts";

function TopicCard({ topic }:Readonly<TopicCardProps>) {
    const navigate = useNavigate();

    function handleClick() {
        navigate(`/question/${topic.id}`)
    }

    return (
        <div className={"topic-container"}>
            <button className={"option-card"} onClick={handleClick}>
                <img className={topic.title.toLowerCase() + "-img option-img"} src={topic.icon} alt={topic.title + " illustration"} />
                <span className={"option-text"}>{topic.title}</span>
            </button>
        </div>
    );
}

export default TopicCard;
